document.addEventListener("DOMContentLoaded", function () {
      const apiKey = 'your-api-key';
      const endPoint = 'your-endpoint';
      const marketplaceAddress = 'your-marketplace-address';
      const walletId = 'your-wallet-id'; // Replace with actual wallet ID

      const nftList = document.getElementById('nft-list');
      const message = document.getElementById('message');
      const buyModal = document.getElementById('buyModal');
      const successModal = document.getElementById('successModal');
      const failedModal = document.getElementById('failedModal');

      const confirmBuy = document.getElementById('confirmBuy');
      const closeBuyModal = document.getElementById('closeBuyModal');
      const closeSuccessModal = document.getElementById('closeSuccessModal');
      const closeFailedModal = document.getElementById('closeFailedModal');

      let selectedNft = null;

      async function fetchNfts() {
        try {
          const response = await fetch(`${endPoint}marketplace/active_listings?network=devnet&marketplace_address=${marketplaceAddress}`, {
            method: 'GET',
            headers: {
              'Content-Type': 'application/json',
              'x-api-key': apiKey,
            }
          });
          const data = await response.json();
          if (data.success) {
            displayNfts(data.result);
          } else {
            message.textContent = 'Some error occurred';
          }
        } catch (error) {
          message.textContent = error.message;
        }
      }

      function displayNfts(nfts) {
        message.textContent = '';
        nfts.forEach(nft => {
          const nftCard = document.createElement('div');
          nftCard.className = 'nft-card';
          nftCard.innerHTML = `
            <img src="${nft.image_uri}" alt="NFT Image">
            <p>${nft.name}</p>
            <button class="buy-btn" data-address="${nft.nft_address}" data-price="${nft.price}" data-seller="${nft.seller_address}">Buy</button>
          `;
          nftList.appendChild(nftCard);
        });

        document.querySelectorAll('.buy-btn').forEach(button => {
          button.addEventListener('click', () => {
            selectedNft = {
              address: button.dataset.address,
              price: button.dataset.price,
              seller: button.dataset.seller,
            };
            buyModal.classList.add('modal-show');
          });
        });
      }

      async function buyNft() {
        try {
          const response = await fetch(`${endPoint}marketplace/buy`, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
              'x-api-key': apiKey,
            },
            body: JSON.stringify({
              network: 'devnet',
              marketplace_address: marketplaceAddress,
              nft_address: selectedNft.address,
              price: Number(selectedNft.price),
              seller_address: selectedNft.seller,
              buyer_wallet: walletId,
            }),
          });
          const data = await response.json();
          if (data.success) {
            successModal.classList.add('modal-show');
          } else {
            failedModal.classList.add('modal-show');
          }
        } catch (error) {
          failedModal.classList.add('modal-show');
        }
      }

      confirmBuy.addEventListener('click', () => {
        buyModal.classList.remove('modal-show');
        buyNft();
      });

      closeBuyModal.addEventListener('click', () => {
        buyModal.classList.remove('modal-show');
      });

      closeSuccessModal.addEventListener('click', () => {
        successModal.classList.remove('modal-show');
      });

      closeFailedModal.addEventListener('click', () => {
        failedModal.classList.remove('modal-show');
      });

      fetchNfts();
    });