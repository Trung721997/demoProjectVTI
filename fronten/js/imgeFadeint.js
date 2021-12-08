//  Set Timeout ============================================================

var myIndex = 0;
setTimeout(carousel, 2000);

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    console.log("x.length", x.length);
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    myIndex++;
    if (myIndex > x.length) { myIndex = 1 }
    x[myIndex - 1].style.display = "block";
    setTimeout(carousel, 1500);
}