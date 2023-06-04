function handleWishlist(id) {

    var text = "Add to Wishlist";
    var button = "button" + id;
    var action = "remove";

    if (text == document.getElementById(button).innerHTML) {
        text = "Remove from Wishlist";
        action = "add";
    }

    document.getElementById(button).innerHTML = text;
    fetch("http://localhost:8080/wishlist/" + action + "/" + id, {method: 'POST'});

}