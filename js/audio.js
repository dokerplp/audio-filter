//https://github.com/mdn/voice-change-o-matic-float-data
function startAudio() {
    const audioCtx = new (window.AudioContext)();
    let source;
    const analyser = audioCtx.createAnalyser();
    const distortion = audioCtx.createWaveShaper();
    const gainNode = audioCtx.createGain();
    const biquadFilter = audioCtx.createBiquadFilter();
    const convolver = audioCtx.createConvolver();

    const canvas = document.getElementById("audio-canvas");
    const ctx = canvas.getContext("2d");
    ctx.canvas.width  = window.innerWidth;

    if (navigator.getUserMedia) {
        navigator.getUserMedia({audio: true},
            function (stream) {
                initAudio(stream);
                visualize();
            },
            function (err) {console.log("The following gUM error occured: " + err);}
        );
    } else {
        console.log("getUserMedia not supported on your browser!");
    }

    function visualize() {
        const WIDTH = canvas.width;
        const HEIGHT = canvas.height;

        analyser.fftSize = 1024;
        const bufferLength = analyser.fftSize;
        audioData = new Float32Array(bufferLength);

        ctx.clearRect(0, 0, WIDTH, HEIGHT);
        function draw() {
            requestAnimationFrame(draw);
            analyser.getFloatTimeDomainData(audioData);

            ctx.fillStyle = "rgb(200, 200, 200)";
            ctx.fillRect(0, 0, WIDTH, HEIGHT);

            ctx.lineWidth = 2;
            ctx.strokeStyle = "rgb(0, 0, 0)";

            ctx.beginPath();

            const sliceWidth = WIDTH / bufferLength;

            let i = 0, x = 0;
            for (; i < bufferLength; i++, x += sliceWidth) {
                const v = audioData[i] * 200.0;
                const y = HEIGHT / 2 + v;

                if (i === 0) ctx.moveTo(x, y);
                else ctx.lineTo(x, y);
            }
            ctx.lineTo(canvas.width, canvas.height / 2);
            ctx.stroke();
        }
        draw();
    }

    function initAudio(stream) {
        source = audioCtx.createMediaStreamSource(stream);
        source.connect(analyser);
        analyser.connect(distortion);
        distortion.connect(biquadFilter);
        biquadFilter.connect(convolver);
        convolver.connect(gainNode);
        gainNode.connect(audioCtx.destination);
    }
}
