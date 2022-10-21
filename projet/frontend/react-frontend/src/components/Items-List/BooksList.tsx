import React, { useState, useEffect, ChangeEvent } from "react";
import { useParams, useNavigate, Link } from 'react-router-dom';
import * as AuthService from "../../services/AuthService";

import ItemService from "../../services/ItemService";
import ItemData from "../../types/Item";

import { FcNext } from 'react-icons/fc';
import UserData from "../../types/User";

const BooksList: React.FC = () => {

    const [items, setItems] = useState<Array<ItemData>>([]);
    const [currentUser, setCurrentUser] = useState<UserData | undefined>(undefined);

    const retrieveItems = () => {
        ItemService.findByNameItem("Book")
            .then((response: any) => {
                setItems(response.data);
            })
            .catch((e: Error) => {
                console.log(e.message);
            });
    };

    useEffect(() => {
        const user = AuthService.getCurrentUser();
        if (user) {
            setCurrentUser(user);
        }
        retrieveItems();
    }, []);

    return (
        <div className="main main-raised">
            <div className="section">
                <div className="container">
                    <div className="row">
                        <div className="col-md-10 ml-auto mr-auto">
                            <div className="title pb-4">
                                <h3>Livres</h3>
                            </div>
                            <div className="card card-plain">
                                {items && items.map((item, index) => (
                                    <div className="row m-2" key={index}>
                                        <div className="col-md-5" >
                                            <img className="image img-thumbnail border-0" width={'200px'} src={"/images/" + item.image} />
                                        </div>
                                        <div className="col-md-7 pb-4">
                                            <h5 className="card-category text-primary text-capitalize">{item.title}</h5>
                                            <p className="card-description ">{item.description.substring(0, 250)}...
                                                <Link className="btn font-weight-bold" to={"/item/" + item.id}>
                                                    Voir plus
                                                </Link>
                                            </p>
                                            {currentUser && (
                                                <div>
                                                    <p className="card-description">Quantité restante : {item.quantity}</p>
                                                    <a className="btn btn-warning btn-round" href="#"><FcNext />Réserver</a>
                                                </div>
                                            )}

                                        </div>
                                        <hr />
                                    </div>
                                ))}
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

    );
}

export default BooksList;