//https://github.com/mdn/samples-server/blob/master/s/webrtc-capturestill/capture.js
function startVideo() {
    const width = 920;
    const height = 480;
    let video = null;
    let canvas = null;

    video = document.getElementById('video');
    canvas = document.getElementById('video-canvas');

    navigator.mediaDevices.getUserMedia({video: true, audio: false})
        .then(function (stream) {
            initVideo(stream)
        })
        .catch(function (err) {
            console.log("An error occurred: " + err);
        });

    function take() {
        canvas.setAttribute('width', width);
        canvas.setAttribute('height', height);
        takePicture();
    }

    setInterval(take, 10);

    function takePicture() {
        const ctx = canvas.getContext('2d');
        if (width && height) {
            canvas.width = width;
            canvas.height = height;

            ctx.translate(width, 0);
            ctx.scale(-1, 1);
            ctx.drawImage(video, 0, 0, width, height);

            const dataUrl = canvas.toDataURL('image/png')
            console.log(dataUrl)

            const img = sendServer(dataUrl);
        }
    }

    function initVideo(stream) {
        video.srcObject = stream;
        video.play();
        video.height = 0;
        video.width = 0;
    }
}