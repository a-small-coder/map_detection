let map;

function initMap() {
  map = new google.maps.Map(document.getElementById("map"), {
    center:{lat: 55.752479,lng: 37.617522},
            zoom: 12
  });

  let elements = document.querySelectorAll('var');
  for (let elem of elements) {
    
    var data = elem.innerText.split('\n            ')
    console.log("elem", elem)
    console.log("data", data)
    console.log(data[3], data[5])

    let marker = new google.maps.Marker({
        position: {lat: parseFloat(data[1]), lng: parseFloat(data[2])},
        map: map,
        title: data[3] + "\n" + data[4],
        url: "/map/" + data[5]
    });
     google.maps.event.addListener(marker, 'click', function() {
          window.location.href = marker.url;
        });
    }
}