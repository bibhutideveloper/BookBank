function openNavCart(){
    // document.getElementById("nav-cart").style.display = "flex";
    document.getElementById("nav-cart").style.width = "100%";
    document.getElementById("nav-cart-inner").style.marginRight = "0";
}

function closeNavCart(){
    document.getElementById("nav-cart").style.width = "0";
    document.getElementById("nav-cart-inner").style.marginRight = "-500px";
}