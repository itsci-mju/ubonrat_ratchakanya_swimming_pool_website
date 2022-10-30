var st = document.getElementById("sec_first");
var nd = document.getElementById("sec_second");
var rd = document.getElementById("sec_third");

function goFirst(){
    st.classList.add("showup_cont");
    st.classList.remove("hidden_cont");

    nd.classList.add("hidden_cont");
    nd.classList.remove("showup_cont");
    
    rd.classList.add("hidden_cont");
    rd.classList.remove("showup_cont");
}

function goSecond(){
    st.classList.add("hidden_cont");
    st.classList.remove("showup_cont");

    nd.classList.add("showup_cont");
    nd.classList.remove("hidden_cont");
    
    rd.classList.add("hidden_cont");
    rd.classList.remove("showup_cont");
}

function goThird(){
    st.classList.add("hidden_cont");
    st.classList.remove("showup_cont");

    nd.classList.add("hidden_cont");
    nd.classList.remove("showup_cont");
    
    rd.classList.add("showup_cont");
    rd.classList.remove("hidden_cont");
}

