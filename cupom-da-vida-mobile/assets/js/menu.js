/* MENU
----------------------------------------------------- */
const menu = document.querySelector("#menu");
const secao1 = document.querySelector("#sobre-mim");

const menuHamburguer = document.querySelector('.menu-hamburguer');
const navMobile = document.querySelector('.filtros.mobile');

menuHamburguer.onclick = () => {
  menuHamburguer.classList.toggle('ativo');
  navMobile.classList.toggle('ativo');
}