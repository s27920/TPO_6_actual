<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/c7b06806bb.js" crossorigin="anonymous"></script>
</head>
<body>
<div id = "searchOptions">
    <label for="searchBox">Search:</label>
    <input type="text" id = "searchBox">
    <button class = "searchBarBtns" id = "searchButton">Search</button>
    <button class = "searchBarBtns" id = "filterButton">Filter</button>
    <button id="exitButton">x</button>
    <hr id="break">

    <div id="featureListDiv">
        <div id = "innerFilterDivInstance1" class = "innerFilterDiv">
            <button id="filterSpanButtonInstance1" class = "filterSpanButton">
                <i id ="FilterLogoSpan1" class="fa-solid fa-wifi"></i>
                Features</button>
            <div class = "ftListDiv">
                <input type="checkbox" name="Pet Friendly" id="dogFriendly" class="featureCheckBox">
                <label for="dogFriendly">Dog friendly</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name="Free Wi-Fi" id="freewifi" class="featureCheckBox">
                <label for="freewifi">Free wifi</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name="Wheelchair Accessible" id="wheelchairaccessible" class="featureCheckBox">
                <label for="wheelchairaccessible">Wheelchair accessible</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name="Outdoor Seating" id="outdoorseating" class="featureCheckBox">
                <label for="outdoorseating">Outdoor seating</label>
            </div>
        </div>
        <div id = "innerFilterDivInstance3" class = "innerFilterDiv">
            <button id="filterSpanButtonInstance3" class = "filterSpanButton">
                <i id ="FilterLogoSpan3" class="fa-solid fa-bowl-food"></i>
                Cuisine</button>
            <div class = "ftListDiv">
                <input type="checkbox" name="Italian" class="cuisineCheckBox" id = "Italian">
                <label for="Italian">Italian</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name="Korean" class="cuisineCheckBox" id = "Korean">
                <label for="Korean">Korean</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name = "Japanese" class="cuisineCheckBox" id = "Japanese">
                <label for="Japanese">Japanese</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name = "Georgian" class="cuisineCheckBox" id = "Georgian">
                <label for="Georgian">Georgian</label>
            </div>
        </div>
        <div id = "innerFilterDivInstance2" class = "innerFilterDiv">
            <button id="filterSpanButtonInstance2" class = "filterSpanButton">
                <i id ="FilterLogoSpan2" class="fa-solid fa-dollar-sign"></i>
                Price range</button>
            <div class = "ftListDiv">
                <input type="checkbox" name = "$$$"; class="priceCheckBox" id="$$$";>
                <label for="$$$";>$$$</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name = "$$" class="priceCheckBox" id="$$">
                <label for="$$">$$</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name = "$" class="priceCheckBox" id="$">
                <label for="$">$</label>
            </div>
        </div>
    </div>

</div>

<div id = "searchBar">
    <button id="removeBtn" onclick="removeAllElements()">purge</button>
    <button id="addBtm" onclick="insertElement()">add</button>
    <i id="searchIcon" class="fa-solid fa-magnifying-glass fa-xl"></i>
</div>

<div id="semi-Body">
    <div id="soapBox">
        <div id="leftBtnDiv" class = "buttonDiv">
            <button id="leftScrollButton" onclick="scrollBack()" class = "scrollBtn">&lt;</button>
        </div>

        <ul id = "enumerate-list">
            <li><div class = "enumerate"></div></li>
            <li><div class = "enumerate"></div></li>
            <li><div class = "enumerate"></div></li>
        </ul>
        <div id="rightBtnDiv" class = "buttonDiv">
            <button id="rightScrollButton" onclick="scrollRight()" class = "scrollBtn">&gt;</button>
        </div>
    </div>
    <div>
        <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d13821.795415809722!2d21.049423755571517!3d52.23663889053836!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1spl!2spl!4v1717341531809!5m2!1spl!2spl" width="800" height="450" style="border:0;z-index: 5;position: relative;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>    </p>
    </div>
</div>

<script src="index.js"></script>
</body>
</html>