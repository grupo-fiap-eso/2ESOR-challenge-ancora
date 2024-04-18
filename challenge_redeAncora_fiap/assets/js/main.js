//adicionando um hovered para os itens quando forem acionados pelo mouse
let list = document.querySelectorAll(" .navigation li");

function activeLink(){
    list.forEach((item) => {
        item.classList.remove("hovered");
    });
    this.classList.add("hovered");
};

list.forEach((item) => item.addEventListener("mouseover", activeLink));

//menu lateral
let menu = document.querySelector(".menu");
let navigation = document.querySelector(".navigation");
let main = document.querySelector(".main");

menu.onclick = function() {
    navigation.classList.add("active");
    main.classList.add("active");
};
