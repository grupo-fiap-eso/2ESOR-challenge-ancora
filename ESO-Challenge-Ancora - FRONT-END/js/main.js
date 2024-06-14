const btn_entrar = document.querySelector("#btn-entrar");
const btn_criar_conta = document.querySelector("#btn-criar-conta");
const container = document.querySelector(".container");
const btn2_entrar = document.querySelector("#entrar-btn2");
const btn2_criar_conta = document.querySelector("#criar-conta-btn2");

btn_criar_conta.addEventListener("click", () => {
    container.classList.add("btn-criar-conta-mode");
});

btn_entrar.addEventListener("click", () => {
    container.classList.remove("btn-criar-conta-mode");
});

btn2_criar_conta.addEventListener("click", () => {
    container.classList.add("btn-criar-conta-mode2");
});

btn2_entrar.addEventListener("click", () => {
    container.classList.remove("btn-criar-conta-mode2");
});

//responsividade cards home e perfil

$(".card").on("click", function(){
    $(".detail").addClass("active");
});

$(".close-detail").on("click", function(){
    $(".detail").removeClass("active");
});

$(".menu-bar").on("click", function(){
    $(".sidebar").addClass("active");
});
