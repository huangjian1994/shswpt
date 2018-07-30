jQuery(function($) {
    $("#all").css({
        "display": "block"
    });
    var url = window.location.href; // 获取当前页面url		
    function find(str, cha, num) {
        var x = str.indexOf(cha);
        for (var i = 0; i < num; i++) {
            x = str.indexOf(cha, x + 1);
        }
        return x;
    }
    var index = find(url, "/", 3);
    var luj = url.substring(0, index);
    console.log(luj);
    $.supersized({
        // Functionality
        slide_interval: 1000, // Length between transitions
        transition: 1, // 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide
        // Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel
        // Left
        transition_speed: 3000, // Speed of transition
        performance: 1, // 0-Normal, 1-Hybrid speed/quality, 2-Optimizes
        // image quality, 3-Optimizes transition speed //
        // (Only works for Firefox/IE, not Webkit)

        // Size & Position
        min_width: 0, // Min width allowed (in pixels)
        min_height: 0, // Min height allowed (in pixels)
        vertical_center: 1, // Vertically center background
        horizontal_center: 1, // Horizontally center background
        fit_always: 0, // Image will never exceed browser width or height
        // (Ignores min. dimensions)
        fit_portrait: 1, // Portrait images will not exceed browser height
        fit_landscape: 0, // Landscape images will not exceed browser width

        // Components
        slide_links: 'blank', // Individual links for each slide (Options:
        // false, 'num', 'name', 'blank')
        slides: [ // Slideshow Images
            {
                image: luj + '/images/bg1.jpg'
            }, {
                image: luj + '/images/bg2.jpg'
            }, {
                image: luj + '/images/bg3.jpg'
            }, {
                image: luj + '/images/bg8.jpg'
            }, {
                image: luj + '/images/bg5.jpg'
            }, {
                image: luj + '/images/bg4.jpg'
            }, {
                image: luj + '/images/bg9.jpg'
            }
        ]

    });

});