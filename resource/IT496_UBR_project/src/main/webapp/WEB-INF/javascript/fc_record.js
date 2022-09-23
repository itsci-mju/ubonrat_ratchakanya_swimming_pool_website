
/* record usage service */
function checktypeinput(){
    var um = document.getElementById("usetype_m");
    var uf = document.getElementById("usetype_f");
    var mb = document.getElementById("member_a");
    var wia = document.getElementById("walkin_a");
    var wib = document.getElementById("walkin_b");
    if(um.checked){
        mb.style.display = "unset"
        wia.style.display = "none"
        wib.style.display = "none"
    }
    else if(uf.checked){
        mb.style.display = "none"
        wia.style.display = "unset"
        wib.style.display = "unset"
    }
}



