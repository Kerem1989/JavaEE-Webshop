$(document).ready(function () {
    $(".linkMinus").on("click", function (evt) {
        evt.preventDefault();
        productId = $(this).attr("pid");
        quantityInput = $("#quantity" + productId);
        newQuantity = parseInt(quantityInput.val()) - 1;

        if (newQuantity > 0) {
            quantityInput.val(newQuantity);
        } else {
            alert("You must have at least 1 item in your cart");
        }
    });
    $(".linkPlus").on("click", function (evt) {
        evt.preventDefault();
        productId = $(this).attr("pid");
        quantityInput = $("#quantity" + productId);
        newQuantity = parseInt(quantityInput.val()) + 1;

        if (newQuantity <= 5) {
            quantityInput.val(newQuantity);
        } else {
            alert("You can only buy a maximum of 5 items");
        }
    });
});
