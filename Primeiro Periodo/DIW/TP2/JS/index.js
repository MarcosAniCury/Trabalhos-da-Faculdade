function getHTMLStarFromProduct(product) {
    const HTMLFullStar = `
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
        <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
    </svg>`;

    const HTMLEmptyStar = `
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star" viewBox="0 0 16 16">
        <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
    </svg>
    `;

    let HTMLStars = '';

    for (let i = 0; i <= 4; i++) {
        if (i < product.number_stars) {
            HTMLStars += HTMLFullStar;
        } else {
            HTMLStars += HTMLEmptyStar;
        }
    }

    return HTMLStars;
}

function getHTMLProduct(product) {
    return `
    <article class="product">
        <div class="div-img-product">
            <img class="img-product" src="Assets/${product.name.toLowerCase().trim().replace(' ', '_')}.jpg" alt="${product.name}">
        </div>
        <legend class="legend-product">${product.name}</legend>
        <div class="div-stars">
            ${getHTMLStarFromProduct(product)} &nbsp;&nbsp; (${product.number_reviews})
        </div>
        <div class="div-product-price">
            <p class="product-price">R$: ${product.price - product.price*(product.discount/100)},00</p>
            &nbsp;&nbsp;
            <p class="product-price-old">R$ ${product.price}</p>
            &nbsp;&nbsp;
            <p class="product-price-old-message">OFF</p>
        </div>
    </article>`;
}

function generateProducts() {
    const products = document.getElementById("section-products");
    products.innerHTML = "";

    mockJSONFile = [
        {
            "name": "Dixit",
            "number_stars": 5,
            "number_reviews": 100,
            "price": 100.00,
            "discount": 10,
        },
        {
            "name": "Ark Nova",
            "number_stars": 4,
            "number_reviews": 59,
            "price": 550.00,
            "discount": 20
        },
        {
            "name": "Looney Boom",
            "number_stars": 3,
            "number_reviews": 10,
            "price": 150.00,
            "discount": 30,
        },
        {
            "name": "7 Wonders",
            "number_stars": 2,
            "number_reviews": 3,
            "price": 500.00,
            "discount": 15,
        },
        {
            "name": "Animix",
            "number_stars": 0,
            "number_reviews": 0,
            "price": 100.00,
            "discount": 5,
        },
        {
            "name": "Bandido",
            "number_stars": 4,
            "number_reviews": 15,
            "price": 70.00,
            "discount": 20,
        },
        {
            "name": "Carcassonne",
            "number_stars": 5,
            "number_reviews": 99,
            "price": 300.00,
            "discount": 40,
        },
        {
            "name": "Century Golem",
            "number_stars": 0,
            "number_reviews": 0,
            "price": 350.00,
            "discount": 24,
        },
        {
            "name": "Colt Express",
            "number_stars": 3,
            "number_reviews": 5,
            "price": 300.00,
            "discount": 7,
        },
        {
            "name": "Deception",
            "number_stars": 4,
            "number_reviews": 9,
            "price": 300.00,
            "discount": 20,
        },
    ];

    if (mockJSONFile.length != 0) {
        mockJSONFile.forEach(product => {
            products.innerHTML += getHTMLProduct(product);
        }) 
    } else {
        products.innerHTML = "<div id=\"div-product-none\"><p>Nenhum resultado foi encontrado</p></div>"
    }
}