
const sideMenu = document.querySelector("aside");
const menuBtn = document.querySelector("#menu-btn");
const closeBtn = document.querySelector("#close-btn");
const themeToggler = document.querySelector(".theme-toggler");

//show sidebar
menuBtn.addEventListener('click', () =>{
    sideMenu.style.display = 'block';
})

//close sidebar
closeBtn.addEventListener('click', () =>{
    sideMenu.style.display = 'none';
})

// muda o tema da página 
themeToggler.addEventListener('click', () =>{
    document.body.classList.toggle('dark-theme-variables');

    themeToggler.querySelector('span:nth-child(1)').classList.toggle('active');
    themeToggler.querySelector('span:nth-child(2)').classList.toggle('active');
})

// GRAFICO CHART

const chart = document.querySelector("#chart").getContext('2d');


new Chart(chart, {
    type: 'line',
    data: {
        labels: ['Cia1', 'Cia2', 'Cia3','Cia4'],

        datasets: [
            {
                label: 'Data',
                data: [10, 70, 80, 90, 20],
                borderColor: 'red',
                borderWidth: 2
            },

            {
                label: 'Data',
                data: [80, 20, 30, 40, 50, 80, 90],
                borderColor: 'blue',
                borderWidth: 2
            }
        ]

    },
    options: {
        responsive: true
    }
})

/* CONTROLE DA PLAYLIST */

let listVideo = document.querySelectorAll('.video-list .vid');
let mainVideo = document.querySelector('.main-video video');
let title = document.querySelector('.main-video .title');

listVideo.forEach(video => {
    video.onclick = () =>{
        listVideo.forEach(vid => vid.classList.remove('active'));
        video.classList.add('active');
        if(video.classList.contains('active')){
            let src = video.children[0].getAttribute('src');
            mainVideo.src = src;
            let text = video.children[1].innerHTML;
            title.innerHTML = text;
        }
    }
})