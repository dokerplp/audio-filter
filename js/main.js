document.getElementById("start").addEventListener("click", (e) => {
    document.getElementById("start").remove();
    document.getElementById("contentarea").style.visibility = "visible";
    startVideo();
    startAudio();
});

let audioData;

function filterImage(image) {
    return sendServer(image)
}

function sendServer(image) {
    let photo = document.getElementById('filtered')

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/audio-filter",
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        data: JSON.stringify({
            image: image,
            audio: Array.from(audioData),
            filter: document.getElementById('filters').value
        }),
        success: function(o) {
            photo.setAttribute('src', o);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            photo.setAttribute('src', image);
        }
    });
}