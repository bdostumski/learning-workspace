const stripe = require('stripe')(
  'pk_test_51QhaBNFxOSh5GP1JLP58O2xaFoVGmmWHSADWRqgISGZGjtmJW6y80QnPnlS4skf4doc9yYsACqcv7mhsfBhUzP3B00Z3TWMK6f'
);

const stripeController = async (req, res) => {
  const { purchase, total_amount, shipping_fee } = req.body;

  const calculateOrderAmount = () => {
    return total_amount + shipping_fee;
  };

  const paymentIntent = await stripe.paymentIntents.create({
    amount: calculateOrderAmount(),
    currency: 'usd',
  });

  res.json({ clientSecret: paymentIntent.client_secret });
};

module.exports = stripeController;
