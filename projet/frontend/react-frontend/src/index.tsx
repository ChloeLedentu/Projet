import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from "react-router-dom";

import App from './App';
import reportWebVitals from './reportWebVitals';

//ReactDOM.render n'est plus pris en charge dans React 18.  Utilisez plutôt createRoot.
//Jusqu'à ce que vous passiez à la nouvelle API, votre application se comportera comme si elle exécutait React 17

const root = ReactDOM.createRoot(document.getElementById("root") as HTMLElement);
root.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>
);

reportWebVitals();