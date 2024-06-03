

turnButtonsOffOn("hidden");
let extendedDiv;
let extendedImg;
let placeHolderDiv;

function insertElement(restName, rating, address, website, priceRange, zipCode){
    let path = "stars/"+ setRating(rating) + ".png";
    let imgPath = "images/"+restName+".jpg";

    const newDiv = document.createElement("div");
    newDiv.style.textAlign = "left";
    newDiv.style.color = "rgb(85, 85, 85)";
    newDiv.className = "enumerate";
    newDiv.style.overflow = "hidden";

    const img = document.createElement("div");
    img.style.display = "flex";
    img.style.justifyContent = "center";
    img.style.paddingTop = "4px"
    newDiv.append(img);

    const imgProper = document.createElement("img");
    imgProper.src = imgPath;
    imgProper.style.width = "192px";
    imgProper.style.borderRadius = "6px";
    imgProper.style.transition = "height 0.14s ease-in-out, width 0.14s ease-in-out";
    img.append(imgProper);

    const newh3 = document.createElement("h3");
    newh3.style.margin = "10px";
    newh3.style.fontFamily = "Dosis";
    newh3.style.fontSize = "25px";
    newh3.style.borderBottom = "2px hsl(0, 0%, 76%) solid"
    newh3.innerText = restName;
    newDiv.append(newh3);

    let starRating = document.createElement("img");
    starRating.src = path;
    starRating.style.width = "80px";
    starRating.style.marginTop = "-20px";
    newDiv.append(starRating);

    let resizedPar = document.createElement("div");

    let par = document.createElement("p");
    par.innerText = address;
    par.className = "tileText";
    newDiv.append(par);

    let parHidden = document.createElement("p");
    parHidden.innerText =  zipCode.substring(0,2) + "-" + zipCode.substring(2,zipCode.length+1)+ "\n" +priceRange;
    parHidden.className = "tileText";

    let mapDiv = document.createElement("div");
    let mapImg = document.createElement("img");
    mapImg.src = "src/main/webapp/images/placeholder.png";
    mapDiv.style.float = "right";
    let mapUpdateButton = document.createElement("p");
    mapUpdateButton.innerText = "See on map";
    mapUpdateButton.style.textAlign = "left";
    mapUpdateButton.style.fontFamily = "'Cabin', Verdana, serif";
    mapUpdateButton.style.marginTop = "0";
    mapUpdateButton.style.marginLeft = "15px";
    mapUpdateButton.style.marginBottom = "5px";
    mapUpdateButton.style.color = "#3a0b9e";
    mapUpdateButton.style.textDecoration = "underline";
    mapUpdateButton.addEventListener("click", ()=>{
        //hardcoded for testing TODO remove later
        updateMap("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d215.99793089017265!2d20.994179630340053!3d52.22998447352774!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x471ecc85d2f64dc3%3A0xe35f891e106337b4!2sMiss%20Kimchi!5e0!3m2!1spl!2spl!4v1717365718913!5m2!1spl!2spl");
    })
    mapDiv.append(mapImg);
    mapDiv.append(mapUpdateButton);
//TODO pls finish
    resizedPar.append(parHidden);
    resizedPar.append(mapDiv);
    resizedPar.style.visibility = "hidden";
    newDiv.append(resizedPar);


    const newLi = document.createElement("li");
    newLi.append(newDiv);
    let target = document.getElementById("enumerate-list");
    target.append(newLi);
    if(checkListScrollability()){
        turnButtonsOffOn("visible");
    }
    newDiv.addEventListener("click", ()=>{
        toggleSize(newDiv, imgProper, "230px", "345px", "200px", "300px", "196px", "288px");
    }, {passive: true});
}

function updateMap(link){
    document.getElementById("map").src=link;
}

function toggleSize(newDiv, imgProper, nh1, nh2, nw1, nw2, iw1, iw2){
    if (extendedDiv && extendedDiv !== newDiv) {
        toggleSize(extendedDiv, extendedImg, nh1, nh2, nw1, nw2, iw1, iw2);
    }
    let fnw1 = parseFloat(nw1);
    let fnw2 = parseFloat(nw2);
    let slide = (((fnw2 - fnw1)/2)*-1);
    if(newDiv.style.height === nh1 || newDiv.style.height === ""){
        let clonedDiv = newDiv.cloneNode(true);
        clonedDiv.style.height = nh1;
        clonedDiv.style.width = nw1;
        clonedDiv.style.visibility = "hidden";
        placeHolderDiv = clonedDiv;
        let nextSibling = newDiv.nextSibling;
        if(nextSibling){
            newDiv.parentNode.insertBefore(clonedDiv, nextSibling);
        }else{
            newDiv.parentNode.append(clonedDiv);
        }
        newDiv.style.left = newDiv.parentNode.getBoundingClientRect().left + "px"
        newDiv.style.position = "absolute";
        newDiv.style.zIndex = '10';
        toggleVisibleDic(newDiv, "visible")
        imgProper.style.width = iw2;
        newDiv.style.height = nh2;
        newDiv.style.width = nw2;
        newDiv.style.transform = "translate(" + slide +"px, 0px)"
    }else{
        toggleVisibleDic(newDiv, "hidden")
        imgProper.style.width = iw1;
        newDiv.style.height = nh1;
        newDiv.style.width = nw1;
        newDiv.style.transform = "translate(0px, 0px)"
        let localTmp = placeHolderDiv;
        placeHolderDiv = null;
        setTimeout(()=>{
            newDiv.style.left = ""
            newDiv.style.zIndex = '1';
            newDiv.style.position = "relative";
            localTmp.parentNode.removeChild(localTmp);
        },300);
    }
    if (extendedDiv === newDiv) {
        extendedDiv = null;
        extendedImg = null;
    } else {
        extendedDiv = newDiv;
        extendedImg = imgProper;
    }
}

function toggleVisibleDic(div, visible){
    const children = Array.from(div.children);
    children.at(children.length - 1).style.visibility = visible;
}

function setRating(textRating){
    let num = Math.round(Number(textRating) * 2);
    return String(num/2);
}

function removeAllElements(){
    const ul = document.getElementById("enumerate-list");
    const children = ul.children;
    if(checkListScrollability()){
        turnButtonsOffOn("hidden");
    }
    Array.from(children).forEach(child =>{
        ul.removeChild(child);
    })
}

function scrollRight() {
    if(extendedDiv){
        toggleSize(extendedDiv, extendedImg, "230px", "345px", "200px", "300px", "196px", "288px");
    }
    const list = document.getElementById("enumerate-list");
    const listWidth = list.scrollWidth;
    const newX = list.scrollLeft + list.clientWidth / 2;
    if (newX <= listWidth) {
        list.scrollTo({
            left: newX,
            behavior: 'smooth'
        });
    } else {
        list.scrollTo({
            left: listWidth,
            behavior: 'smooth'
        });
    }
}
function scrollBack(){
    if(extendedDiv){
        toggleSize(extendedDiv, extendedImg, "230px", "345px", "200px", "300px", "196px", "288px");
    }
    const list = document.getElementById("enumerate-list");
    const newX = list.scrollLeft - list.clientWidth / 2;

    if(newX >= 0){
        list.scrollTo({
            left: newX,
            behavior: "smooth"
        })
    }else{
        list.scrollTo({
            left: 0,
            behavior: "smooth"
        })
    }
}

function checkListScrollability(){
    const list = document.getElementById("enumerate-list");
    if (list.scrollWidth > list.clientWidth){
        return true;
    }
    return false;
}
document.getElementById("searchButton").addEventListener("click", ()=>{
    search();
});

function search(){
    let searchPhrase = document.getElementById("searchBox").value;
    let featureCheckBoxes = Array.from(document.getElementsByClassName("featureCheckBox"));
    let cuisineCheckBoxes = Array.from(document.getElementsByClassName("cuisineCheckBox"));
    let priceCheckBoxes = Array.from(document.getElementsByClassName("priceCheckBox"));
    let featuresChecked = [];
    let cusinesChecked = [];
    let pricesChecked = [];

    featureCheckBoxes.forEach(checkBox=>{
        if(checkBox.checked){
            featuresChecked.push(checkBox.name);
        }
    });
    cuisineCheckBoxes.forEach(cuisineBox=>{
        if(cuisineBox.checked){
            cusinesChecked.push(cuisineBox.name)
        }
    });
    priceCheckBoxes.forEach(priceBox=>{
        if(priceBox.checked){
            pricesChecked.push(priceBox.name);
        }
    });
    closeOutSearchBar(document.getElementById("searchOptions"));

    const requestJson ={
        search: searchPhrase,
        features: featuresChecked,
        cuisines: cusinesChecked,
        prices: pricesChecked
    };
    fetch('hello-servlet', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestJson)
    })
        .then(response => {
            return response.json();
        })
        .then(result => {
            removeAllElements();
            result.forEach(restaurant =>{
                insertElement(restaurant.name, restaurant.rating, restaurant.address, restaurant.website, restaurant.priceRange, restaurant.zipCode);
            });
            console.log('Success:', result);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function turnButtonsOffOn(toggle){
    //quick note. I spent about an hour trying to overengineer a fancy solution instead of just passing a string... fml
    const buttons = document.querySelectorAll(".scrollBtn");
    buttons.forEach(button =>{
        button.style.visibility = toggle;
    })
}

document.getElementById("searchIcon").addEventListener("click", event =>{
    let target = document.getElementById("searchOptions");
    closeOutSearchBar(target);
});

document.getElementById("exitButton").addEventListener("click", event=>{
    let target = document.getElementById("searchOptions");
    closeOutSearchBar(target);
});


document.getElementById("filterButton").addEventListener("click", ()=>{
    let target = document.getElementById("searchOptions");
    extend(target, "300px", "25px");
});

function closeOutSearchBar(target){
    if (target.style.height === "300px" && target.style.top === "0px") {
        extend(target, "300px", "25px");
        setTimeout(()=>{
            slideTmp(target, "-25px");
        },100);
    }else{
        slideTmp(target, "-25px")
    }
}

function extend(target, extended, shrunk){
    if (target.style.height === shrunk || target.style.height==="") {
        target.style.height = extended;
    } else {
        target.style.height = shrunk;
    }
}
function slideTmp(target, ammount){
    if(target.style.top === ammount || target.style.top===""){
        target.style.top = "0px"
    }else{
        target.style.top = ammount
    }
}

document.getElementById("filterSpanButtonInstance1").addEventListener("click", event=>{
    let target = event.target.parentNode;
    extend(target, "200px", "20px")
});
document.getElementById("filterSpanButtonInstance2").addEventListener("click", event=>{
    let target = event.target.parentNode;
    extend(target, "200px", "20px")
});
document.getElementById("filterSpanButtonInstance3").addEventListener("click", event=>{
    let target = event.target.parentNode;
    extend(target, "200px", "20px")
});