turnButtonsOffOn("hidden");
let extendedDiv;
let extendedImg;
let placeHolderDiv;
fetchFromServer("",[],[],[]);

function insertElement(restName, rating, address,iframe,  website, priceRange, zipCode){
    let path = "stars/"+ setRating(rating) + ".png";
    let imgPath = "imgs/"+restName+".jpg";

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
    if (imgProper.style.height !== "128px"){
        imgProper.style.height = "128px"
    }
    imgProper.style.borderRadius = "6px";
    imgProper.style.transition = "height 0.14s ease-in-out, width 0.14s ease-in-out";
    img.append(imgProper);

    const newh3 = document.createElement("h3");
    newh3.style.margin = "10px";
    newh3.style.fontFamily = "Dosis";
    newh3.style.fontSize = "15px";
    newh3.style.borderBottom = "2px hsl(0, 0%, 76%) solid"
    newh3.innerText = restName;
    newDiv.append(newh3);

    let starRating = document.createElement("img");
    starRating.src = path;
    starRating.style.width = "80px";
    starRating.style.marginTop = "-20px";
    newDiv.append(starRating);

    let par = document.createElement("p");
    par.innerText = address;
    par.className = "tileText";
    newDiv.append(par);

    let utilDiv = document.createElement("div");
    utilDiv.style.width = "300px";
    utilDiv.style.height = "69px";
    utilDiv.style.overflow = "hidden";
    // utilDiv.style.backgroundColor = "blue";
    utilDiv.style.visibility = "hidden";
    utilDiv.style.display = "flex";
    utilDiv.style.flexDirection = "row";
    utilDiv.style.justifyContent = "space-evenly";
    utilDiv.style.marginTop = "-20px";
    let mapButton = document.createElement("button");
    mapButton.style.width = "120px"
    mapButton.style.height = "35px"
    mapButton.innerText = "See on map"
    mapButton.style.textAlign = "center";
    mapButton.style.borderRadius = "15px"
    mapButton.style.backgroundColor = "rgb(246, 243, 240)";
    mapButton.style.border = "2px rgb(147,147,147) solid";
    mapButton.addEventListener("click",()=>{
        updateMap(iframe);
    });

    let orderButton = document.createElement("button");
    orderButton.style.width = "115px"
    orderButton.style.height = "35px"
    orderButton.innerText = "Place order"
    orderButton.style.textAlign = "center";
    orderButton.style.borderRadius = "15px"
    orderButton.style.backgroundColor = "rgb(246, 243, 240)";
    orderButton.style.border = "2px rgb(147,147,147) solid";

    orderButton.addEventListener("click", ()=>{
        window.location.href = website;
    });
    if (website !== 'unavailable'){
        utilDiv.append(orderButton);
    }
    utilDiv.append(mapButton);

    newDiv.append(utilDiv);


    const newLi = document.createElement("li");
    newLi.append(newDiv);
    let target = document.getElementById("enumerate-list");
    target.append(newLi);
    if(checkListScrollability()){
        turnButtonsOffOn("visible");
    }
    newDiv.addEventListener("click", ()=>{
        toggleSize(newDiv, imgProper, "230px", "330px", "200px", "300px", "196px", "288px", "128px", "194px");
    }, {passive: true});
}

function updateMap(link){
    document.getElementById("map").src=link;
}

function toggleSize(newDiv, imgProper, nh1, nh2, nw1, nw2, iw1, iw2, ih1, ih2){
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
        imgProper.style.height = ih2;
        newDiv.style.height = nh2;
        newDiv.style.width = nw2;
        newDiv.style.transform = "translate(" + slide +"px, 0px)"
    }else{
        let localTmp = placeHolderDiv;
        placeHolderDiv = null;
        imgProper.style.height = ih1;
        imgProper.style.width = iw1;
        newDiv.style.height = nh1;
        newDiv.style.width = nw1;
        newDiv.style.transform = "translate(0px, 0px)"
        toggleVisibleDic(newDiv, "hidden")
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
        toggleSize(extendedDiv, extendedImg, "230px", "330px", "200px", "300px", "196px", "288px", "128px", "194px");
        setTimeout(scrollRight, 250);
        return;
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
        toggleSize(extendedDiv, extendedImg, "230px", "330px", "200px", "300px", "196px", "288px", "128px", "194px");
        setTimeout(scrollBack, 250);
        return;
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
    return list.scrollWidth > list.clientWidth;

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
    fetchFromServer(searchPhrase, featuresChecked, cusinesChecked, pricesChecked);
}
function fetchFromServer(searchPhrase, featuresChecked, cusinesChecked, pricesChecked){
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
                insertElement(restaurant.name, restaurant.rating, restaurant.address, restaurant.iframe, restaurant.website, restaurant.priceRange, restaurant.zipCode);
            });
            console.log('Success:', result);
            return true;
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

// document.getElementById("exitButton").addEventListener("click", event=>{
//     let target = document.getElementById("searchOptions");
//     closeOutSearchBar(target);
// });


document.getElementById("filterButton").addEventListener("click", ()=>{
    let target = document.getElementById("searchOptions");
    extend(target, "80px", "25px");
});

function resizeOptions(){
    let opts1 = document.getElementById("filterSpanButtonInstance1");
    let opts2 = document.getElementById("filterSpanButtonInstance1");
    let opts3 = document.getElementById("filterSpanButtonInstance1");
    let moved = false;
    if (opts1.style.height === "200px"){
        extend(opts1, "200px", "20px")
        moved = true;
    }
    if (opts2.style.height === "100px"){
        extend(opts1, "100px", "20px")
        moved = true;
    }
    if (opts3.style.height === "300px"){
        extend(opts1, "300px", "20px")
        moved = true;
    }
    return moved;
}

function closeOutSearchBar(target){
    if (resizeOptions()){
        setTimeout(()=> {
            closeOutSearchBar
        },300);
    }
    if (target.style.height === "80px" && target.style.top === "0px") {
        extend(target, "80px", "25px");
        setTimeout(()=>{
            slideTmp(target, "-27px");
        },100);
    }else{
        slideTmp(target, "-27px")
    }
}


function extend(target, extended, shrunk){
    if (target.style.height === shrunk || target.style.height==="") {
        target.style.height = extended;
        target.style.overflow = "visible";
    } else {
        target.style.overflow = "hidden";
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
    extend(target, "100px", "20px")
});
document.getElementById("filterSpanButtonInstance3").addEventListener("click", event=>{
    let target = event.target.parentNode;
    extend(target, "300px", "20px")
});