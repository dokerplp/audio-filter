document.getElementById("start").addEventListener("click", (e) => {
    document.getElementById("start").remove();
    document.getElementById("audio-canvas").style.visibility = "visible";
    document.getElementById("video-canvas").style.visibility = "visible";
    startVideo();
    startAudio();
});

let audioData;

function sendServer(image) {
    console.log(audioData)
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/audio-filter",
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        data: JSON.stringify({
            image: image,
            audio: Array.from(audioData)
        })
    }).done(function(o) {
        //console.log('saved');
    });

    return image
}