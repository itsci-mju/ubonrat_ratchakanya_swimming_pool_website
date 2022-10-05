<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <ul class="slideshow">
        <li><span class="sldsw"></span></li>
        <li><span class="sldsw"></span></li>
        <li><span class="sldsw"></span></li>
        <li><span class="sldsw"></span></li>
        <li><span class="sldsw"></span></li>
      </ul>
</body>
<style>
    .slideshow {
  list-style-type: none;
}

/** SLIDESHOW **/
.slideshow,
.slideshow:after { 
    top: -16px; /*Not sure why I needed this fix*/
		position: fixed;
    width: 100%;
    height: 100%;
    left: 0px;
    z-index: 0; 
}

.slideshow li span { 
		position: absolute;
    width: 100%;
    height: 100%;
    top: 0px;
    left: 0px;
    color: transparent;
    background-size: cover;
    background-position: 50% 50%;
    background-repeat: no-repeat;
    opacity: 0;
    z-index: 0;
    animation: imageAnimation 30s linear infinite 0s; 
}



.slideshow li:nth-child(1) span { 
    background-image: url("img/sl1.jpg"); 
}
.slideshow li:nth-child(2) span { 
    background-image: url("img/sl2.jpg"); 
    animation-delay: 6s; 
}
.slideshow li:nth-child(3) span { 
    background-image: url("img/sl3.jpg"); 
    animation-delay: 12s; 
}
.slideshow li:nth-child(4) span { 
    background-image: url("img/sl4.jpg"); 
    animation-delay: 18s; 
}

.slideshow:hover .sldsw{
    animation-play-state:paused;
}


@keyframes imageAnimation { 
    0% { opacity: 0; animation-timing-function: ease-in; }
    8% { opacity: 1; animation-timing-function: ease-out; }
    17% { opacity: 1 }
    25% { opacity: 0 }
    100% { opacity: 0 }
}


@keyframes titleAnimation { 
    0% { opacity: 0 }
    8% { opacity: 1 }
    17% { opacity: 1 }
    19% { opacity: 0 }
    100% { opacity: 0 }
}


.no-cssanimations .cb-slideshow li span {
	opacity: 1;
}
</style>
</html>