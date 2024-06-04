<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="tpoStyle.css">
    <script src="https://kit.fontawesome.com/c7b06806bb.js" crossorigin="anonymous"></script>
</head>
<body id = "body">
<div id = "searchOptions">
    <label for="searchBox">Search:</label>
    <input type="text" id = "searchBox">
    <button class = "searchBarBtns" id = "searchButton">Search</button>
    <button class = "searchBarBtns" id = "filterButton">Filter</button>
    <hr id="break">

    <div id="featureListDiv">
        <div id = "innerFilterDivInstance1" class = "innerFilterDiv">
            <button id="filterSpanButtonInstance1" class = "filterSpanButton">
                <i id ="FilterLogoSpan1" class="fa-solid fa-wifi"></i>
                Features</button>
            <div class = "ftListDiv">
                <input type="checkbox" name="Pet Friendly" id="dogFriendly" class="featureCheckBox">
                <label for="dogFriendly">Pet Friendly</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name="Wheelchair Accessible" id="wheelchairaccessible" class="featureCheckBox">
                <label for="wheelchairaccessible">Wheelchair accessible</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name="Outdoor Seating" id="outdoorseating" class="featureCheckBox">
                <label for="outdoorseating">Outdoor seating</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name="Takeout" id="Takeout" class="featureCheckBox">
                <label for="Takeout">Takeout</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name="Air conditioning" id="Air conditioning" class="featureCheckBox">
                <label for="Air conditioning">Air conditioning</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name="Shopping" id="Shopping" class="featureCheckBox">
                <label for="Shopping">Shopping</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name="Outdoor Seating" id="Fast Service" class="featureCheckBox">
                <label for="outdoorseating">Fast Service</label>
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
            <div class = "ftListDiv">
                <input type="checkbox" name = "Balkan" class="cuisineCheckBox" id = "Balkan">
                <label for="Balkan">Balkan</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name = "Mexican" class="cuisineCheckBox" id = "Mexican">
                <label for="Mexican">Mexican</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name = "Greek" class="cuisineCheckBox" id = "Greek">
                <label for="Greek">Greek</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name = "Chinese" class="cuisineCheckBox" id = "Chinese">
                <label for="Chinese">Chinese</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name = "Turkish" class="cuisineCheckBox" id = "Turkish">
                <label for="Turkish">Turkish</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name = "Breakfast" class="cuisineCheckBox" id = "Breakfast">
                <label for="Breakfast">Breakfast</label>
            </div>
            <div class = "ftListDiv">
                <input type="checkbox" name = "Polish" class="cuisineCheckBox" id = "Polish">
                <label for="Polish">Polish</label>
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
    <button id="addBtm" onclick="insertElement('Dragon Delight','','','','','','')">add</button>
    <i id="searchIcon" class="fa-solid fa-magnifying-glass fa-xl"></i>
</div>

<div id="semi-Body">
    <div id="soapBox">
        <div id="leftBtnDiv" class = "buttonDiv">
            <button id="leftScrollButton" class="scrollBtn" onclick="scrollBack()">
                <span class = "deformed">&lt;</span>
            </button>
        </div>

        <ul id = "enumerate-list">
            <li><div class = "enumerate"></div></li>
            <li><div class = "enumerate"></div></li>
            <li><div class = "enumerate"></div></li>
        </ul>
        <div id="rightBtnDiv" class = "buttonDiv">
            <button id="rightScrollButton" onclick="scrollRight()" class = "scrollBtn">
                <span class = "deformed">&gt;</span>
            </button>
        </div>
    </div>
</div>

<div id = "wrapper">
    <iframe id="map" src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d13821.795415809722!2d21.049423755571517!3d52.23663889053836!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1spl!2spl!4v1717341531809!5m2!1spl!2spl" width="95%" height="95%" style="border:0;position: relative" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
</div>


<script src="index.js"></script>
</body>
</html>