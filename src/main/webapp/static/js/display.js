
let dragon_image, loot_image, main_character_image, orc_image, skeleton_image, slime_image, wall_image;
let dir = 'static/img/';
let ext = '.png';
let mapObjects = [];

function preload() {
    loadImages();
}

function setup() {
    noLoop();
    createCanvas(490, 490);
    background(100);
}


function draw() {
    drawBoard()
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

function ajax_get(url, callback, action) {
    let xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        let data;
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            console.log('responseText:' + xmlhttp.responseText);
            try {
                data = JSON.parse(xmlhttp.responseText);
            } catch(err) {
                console.log(err.message + " in " + xmlhttp.responseText);
                return;
            }
            callback(data);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader('action', action);
    xmlhttp.send();

}

//ajax test bound to a button temp.
let button = document.getElementById('test');
button.onclick = function () {

    ajax_get('/send', function (data) {
        mapObjects = data;
        draw();
    }, 'map')
};


function drawBoard() {

    for (let i = 0; mapObjects.length; i++) {
        let object = mapObjects[i];
        switch (object.name) {
            case 'DRAGON': image(dragon_image, object.x*50, object.y*50, height/12, width/12);
                break;
            case 'LOOT': image(loot_image, object.x*50, object.y*50, height/12, width/12);
                break;
            case 'MAIN_CHARACTER': image(main_character_image, object.x*50, object.y*50, height/12, width/12);
                break;
            case 'SKELETON': image(skeleton_image, object.x*50, object.y*50, height/12, width/12);
                break;
            case 'SLIME': image(slime_image, object.x*50, object.y*50, height/12, width/12);
                break;
            case 'WALL': image(wall_image, object.x*50, object.y*50, height/12, width/12);
                break;
            case 'ORC': image(orc_image, object.x*50, object.y*50, height/12, width/12)
        }
    }

}


//arrow handlers
document.onkeydown = function(e) {
    let handled;
    if (e.keyCode !== undefined) {
        switch (e.keyCode) {
            case 37: //left
                alert('left');
                handled = true;
                break;
            case 39: //right
                alert('right');
                handled = true;
                break;
            case 38: //up
                alert('up');
                handled = true;
                break;
            case 40: //down
                alert('down');
                handled = true;
                break;
        }
        if (handled) {
            e.preventDefault();
        }
    }
};
