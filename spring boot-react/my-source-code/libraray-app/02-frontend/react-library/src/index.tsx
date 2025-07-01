import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { App } from './App';
import { BrowserRouter } from "react-router-dom";
import {loadStripe} from "@stripe/stripe-js"
import {Elements} from "@stripe/react-stripe-js"

const stripePromise = loadStripe('pk_test_51QnIoDJey56oViN2UdXPoAPU4GyPSJ3T0dqQxttIsa1tUDH8nVroFA5w4x9TAgakJfmOSXGzM8b8OPWq1v5Uv2in00P0nA4cN4')

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <BrowserRouter>
  <Elements stripe={stripePromise}>
    <App />
  </Elements>
  </BrowserRouter>
);
