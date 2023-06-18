function updateWishlist(id, type) {

    var text = "Add to Wishlist";
    var button = "button" + id;

    if (text == document.getElementById(button).innerHTML) {
        text = "Remove from Wishlist";
    }

    document.getElementById(button).innerHTML = text;
    fetch("http://localhost:8080/wishlist/update/" + type + "/" + id, {method: 'POST'});

}