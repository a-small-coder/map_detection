let map;
// функция для отображения карты
function initMap() {
  // берем данные, которые передали и центрируем карту по координатам из данных
  let lat = Number(document.getElementById("lat").value);
  let lng = Number(document.getElementById("lng").value);
  let data = [lat, lng];
    map = new google.maps.Map(document.getElementById("map"), {
          center:{lat: parseFloat(data[0]), lng: parseFloat(data[1])},
                  zoom: 16
        });
    // передаем в маркер всю инфу о дефекте и отображаем
    new google.maps.Marker({
        position: {lat: parseFloat(data[0]), lng: parseFloat(data[1])},
        map: map})

}
