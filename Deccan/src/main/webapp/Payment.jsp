
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Method - Flight Booking</title>
    <link rel="stylesheet" href="Payment.css">
</head>
<body style="font-family: 'Times New Roman', Times, serif;">
    <div class="container" style="margin-top: 60px;">
        <header>
            <h1 style="font-family: 'Times New Roman', Times, serif;">Flight Booking - Payment Method</h1>
        </header>

        <div class="payment-details">
            <h2>Payment Information</h2>

            <div class="passenger-info">
                <h3>Passenger Details</h3>
                <form action="#">
                    <div class="form-group">
                        <label for="name">Full Name:</label>
                        <input type="text" id="name" name="name" placeholder="Enter your full name" required>
                    </div>

                    <div class="form-group">
                        <label for="email">Email Address:</label>
                        <input type="email" id="email" name="email" placeholder="Enter your email address" required>
                    </div>
                </form>
            </div>

            <!-- Payment Method -->
            <div class="payment-method">
                <h3>Choose Payment Method</h3>
                <form action="#">
                    <div class="payment-option">
                        <input type="radio" id="credit-card" name="payment-method" value="credit-card" checked>
                        <label for="credit-card">Credit/Debit Card</label>
                    </div>

                    <div class="payment-option">
                        <input type="radio" id="paypal" name="payment-method" value="paypal">
                        <label for="paypal">PayPal</label>
                    </div>

                    <div class="payment-option">
                        <input type="radio" id="net-banking" name="payment-method" value="net-banking">
                        <label for="net-banking">Net Banking</label>
                    </div>
                </form>
            </div>

            <div class="payment-details-form">
                <h3>Payment Details</h3>
                <div class="form-group">
                    <label for="card-number">Card Number:</label>
                    <input type="text" id="card-number" name="card-number" placeholder="Enter your card number" required>
                </div>

                <div class="form-group">
                    <label for="expiry-date">Expiry Date:</label>
                    <input type="text" id="expiry-date" name="expiry-date" placeholder="MM/YY" required>
                </div>

                <div class="form-group">
                    <label for="cvv">CVV:</label>
                    <input type="text" id="cvv" name="cvv" placeholder="Enter CVV" required>
                </div>
            </div>

            <!-- Booking Summary Section -->
            <div class="booking-summary">
                <h3>Booking Summary</h3>
                <ul>
                    <li><strong>Flight:</strong> ${sessionScope.flightNum}</li>
                    <li><strong>Flight Name:</strong> ${sessionScope.flightName}</li>
                    <li><strong>Total Amount:</strong> ${sessionScope.net}</li>
                </ul>
            </div>

            <div class="submit-btn">
                <button type="submit">Pay Now</button>
            </div>
        </div>
    </div>
</body>
</html>
