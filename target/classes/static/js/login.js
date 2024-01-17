function openNavLogin(){
    document.getElementById("nav-user").style.marginTop = "0"; 
    document.getElementById("nav-user").style.transition = "all 0.3s"; 
}

function closeNavLogin(){
    document.getElementById("nav-user").style.marginTop = "-100vh"; 
    document.getElementById("nav-user").style.transition = "all 0.3s"; 
}

// password
function showPassword(){
    document.getElementById("password").type="text";
    document.getElementById("show-password").style.display="none";
    document.getElementById("hide-password").style.display="flex";
}

function hidePassword(){
    document.getElementById("password").type="password";
    document.getElementById("show-password").style.display="block";
    document.getElementById("hide-password").style.display="none";
}
