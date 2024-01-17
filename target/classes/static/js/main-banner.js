let slideIndex = 1;

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function showSlides(n) {
  let i;
  let slides = document.getElementsByClassName("mySlides");

  if (n > slides.length) {
    slideIndex = 1;
  }
  if (n < 1) {
    slideIndex = slides.length;
  }

  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }

  slides[slideIndex - 1].style.display = "block";

  // Call showSlides again after 2 seconds
  setTimeout(function() {
    plusSlides(1);
  }, 4000);
}

// Trigger the showSlides function after the page is fully loaded
window.onload = function() {
  showSlides(slideIndex);
};
