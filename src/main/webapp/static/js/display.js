
let dragon_image, loot_image, main_character_image, orc_image, skeleton_image, slime_image, wall_image;
let dir = 'static/img/';
let ext = '.png';

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
    let xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            console.log('responseText:' + xmlhttp.responseText);
            try {
                let data = JSON.parse(xmlhttp.responseText);
            } catch(err) {
                console.log(err.message + " in " + xmlhttp.responseText);
                return;
            }
            callback(data);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send('map');

}

//ajax test bound to a button temp.
let button = document.getElementById('test');
button.onclick = function () {

    ajax_get('/send', function (data) {
        for (x in data) {
            for (y in data[x]) {
                switch (data[x][y].name) {
                    case 'DRAGON': image(dragon_image, x*50, y*50, height/12, width/12);
                        break;
                    case 'LOOT': image(loot_image, x*50, y*50, height/12, width/12);
                        break;
                    case 'MAIN_CHARACTER': image(main_character_image, x*50, y*50, height/12, width/12);
                        break;
                    case 'SKELETON': image(skeleton_image, x*50, y*50, height/12, width/12);
                        break;
                    case 'SLIME': image(slime_image, x*50, y*50, height/12, width/12);
                        break;
                    case 'WALL': image(wall_image, x*50, y*50, height/12, width/12);
                        break;
                }
            }
        }
    })
};


//arrow handlers
document.onkeydown = function(e) {
    switch (e.key) {
        case 37: //left
            alert('left');
            break;
        case 39: //right
            alert('right');
            break;
        case 38: //up
            alert('up');
            break;
        case 40: //down
            alert('down');
            break;
    }
};
