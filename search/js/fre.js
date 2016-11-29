$('.page2-box').click(function () {
    $('.popup').fadeIn();
});

$('.close').click(function () {
    $('.popup').fadeOut();
});



$(window).scroll(function () {
    if ($(this).scrollTop() > 1000) {
        $(".up").addClass("up-show");
        $('.up').fadeIn();
    } else {
        $('.up').fadeOut();
    }
});

$('.up').click(function () {
    $("html, body").animate({
        scrollTop: 0
    }, 500);
    return false;
});


   
