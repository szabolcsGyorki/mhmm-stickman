var array = [[1,2,3,4], [1,2,3,4], [1,2,3,4]];

var dragon_image, loot_image, main_character_image, orc_image, skeleton_image, slime_image, wall_image;
var dir = 'static/img/';
var ext = '.png';

function preload() {
    loadImages();
}

function setup() {
    createCanvas(500, 500);
    background(100);
}


function draw() {


}


function loadImages() {
    dragon_image = loadImage(dir + 'image_dragon' + ext);
    loot_image = loadImage(dir + 'image_loot' + ext);
    main_character_image = loadImage(dir + 'image_main_character' + ext);
    orc_image = loadImage(dir + 'image_orc' + ext);
    skeleton_image = loadImage(dir + 'image_skeleton' + ext);
    slime_image = loadImage(dir + 'image_slime' + ext);
    wall_image = loadImage(dir + 'image_wall' + ext);
}

function ajax_get(url, callback) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            console.log('responseText:' + xmlhttp.responseText);
            try {
                var data = JSON.parse(xmlhttp.responseText);
            } catch(err) {
                console.log(err.message + " in " + xmlhttp.responseText);
                return;
            }
            callback(data);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

var button = document.getElementById('test');
button.onclick = function () {

    ajax_get('/send', function (data) {
        for (x in data) {
            for (y in data[x]) {
                switch (data[x][y].name) {
                    case 'DRAGON': image(dragon_image);
                        break;
                    case 'LOOT': image(loot_image);
                        break;
                    case 'MAIN_CHARACTER': image(main_character_image);
                        break;
                    case 'SKELETON': image(skeleton_image);
                        break;
                    case 'SLIME': image(slime_image);
                        break;
                    case 'WALL': image(wall_image);
                        break;
                }
            }
        }
    })


};
