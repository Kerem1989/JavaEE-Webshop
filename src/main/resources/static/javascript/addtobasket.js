$(document).ready(function() {
    $("#buttonAdd2Cart").on("click", function(evt) {
        addToCart();
    });
});

function addToCart() {
    var quantity = $("#quantity" + productId).val();
    var userId = $("#userId").val(); // Get the user ID from the hidden input field
    var url = contextPath + "basket/add/" + productId + "/" + quantity + "/" + userId;

    $.ajax({
        type: "POST",
        url: url,
        beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeaderName, csrfValue);
        }
    }).done(function(response) {
        showModalDialog("Shopping Cart", response);
    }).fail(function() {
        showErrorModal("Error while adding product to shopping cart.");
    });
}