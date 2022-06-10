//pie
var message = /*[[${points}]]*/ "";
    console.log(message)
var ctxP = document.getElementById("pieChart").getContext('2d');
var myPieChart = new Chart(ctxP, {
  type: 'pie',
  data: {
    labels: ["Сделано", "В работе", "Ожидает"],
    datasets: [{
      data: [10, 30, 80],
      backgroundColor: ["#46BFBD", "#FDB45C", "#F7464A"],
      hoverBackgroundColor: ["#5AD3D1", "#FFC870", "#FF5A5E"]
    }]
  },
  options: {
    legend: {
        display: false
    },
    responsive: true
  }
});
