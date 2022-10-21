import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import { useEffect, useState } from "react";

import * as AuthService from "./services/AuthService";
import UserData from "./types/User";

import Accueil from './components/Accueil';
import BooksList from "./components/Items-List/BooksList";
import DvdList from "./components/Items-List/DvdList";
import CdList from "./components/Items-List/CdList";
import Signin from './components/Signin';
import Profil from './components/Profil';
import ItemDetail from "./components/ItemDetail";
import Register from "./components/Register";
import BorrowList from "./components/Borrow";


const App: React.FC = () => {
  const [currentUser, setCurrentUser] = useState<UserData | undefined>(undefined);

  const logOut = () => {
    AuthService.logout();
    setCurrentUser(undefined);
  };

  useEffect(() => {
    const user = AuthService.getCurrentUser();

    if (user) {
      setCurrentUser(user);
    }

  }, []);



  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container">
          <a href="/" className="navbar-brand">
            <img width={"50px"} src="/logo192.png" alt="logo" />
          </a>
          <div className="collapse navbar-collapse">
            <ul className="navbar-nav mr-auto mt-2 mt-lg-0">
              <li className="nav-item ">
                <Link to={"/"} className="nav-link active" >
                  Accueil
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/dvd"} className="nav-link">
                  Dvd
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/cd"} className="nav-link">
                  Cd
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/livres"} className="nav-link">
                  Livres
                </Link>
              </li>
            </ul>
          </div>
          <div className="float-right">
            <ul className="navbar-nav ">
              {!currentUser && (
                <li className="nav-item">
                  <Link to={"/login"} className="nav-link">
                    Connexion
                  </Link>
                </li>
              )}
              {!currentUser && (
                <li className="nav-item">
                  <Link to={"/register"} className="nav-link">
                    Inscription
                  </Link>
                </li>
              )}
              {currentUser && (
                <li className="nav-item">
                  <Link to={"/profil"} className="nav-link">
                    Profil
                  </Link>
                </li>
              )}
              {currentUser && (
                <li className="nav-item">
                  <Link to={"/reservation"} className="nav-link">
                    Réservations
                  </Link>
                </li>
              )}
              {currentUser && (
                <li className="nav-item">
                  <a href="/login" className="nav-link" onClick={logOut}>
                    Deconnexion
                  </a>
                </li>
              )}
            </ul>
          </div>
        </div>
      </nav>

      <div className="container mt-3">
        <Routes>
          <Route path="/" element={<Accueil />} />
          <Route path="/dvd" element={<DvdList />} />
          <Route path="/cd" element={<CdList />} />
          <Route path="/livres" element={<BooksList />} />
          <Route path="/login" element={<Signin />} />
          <Route path="/register" element={<Register />} />
          <Route path="/profil" element={<Profil />} />
          <Route path="/item/:id" element={<ItemDetail />} />
          <Route path="/reservation" element={<BorrowList />} />
        </Routes>
      </div>
    </div>

  );
}

export default App;
