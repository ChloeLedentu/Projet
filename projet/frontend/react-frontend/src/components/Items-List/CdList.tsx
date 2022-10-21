import React, { useState, useEffect, ChangeEvent } from "react";
import { useParams, useNavigate, Link } from 'react-router-dom';

import ItemService from "../../services/ItemService";
import ItemData from "../../types/Item";

import { FcNext } from 'react-icons/fc';

const CdList: React.FC = () => {

    const [items, setItems] = useState<Array<ItemData>>([]);

    useEffect(() => {
        retrieveItems();
    }, []);

    const retrieveItems = () => {
        ItemService.findByNameItem("Cd")
            .then((response: any) => {
                setItems(response.data);
            })
            .catch((e: Error) => {
                console.log(e.message);
            });
    };

    return (
        <div className="main main-raised">
            <div className="section">
                <div className="container">
                    <div className="row">
                        <div className="col-md-10 ml-auto mr-auto">
                            <div className="title pb-4">
                                <h3>Cd</h3>
                            </div>
                            <div className="card card-plain">
                                {items && items.map((item, index) => (
                                    <div className="row m-2" key={index}>
                                        <div className="col-md-5">
                                            <img className="image img-thumbnail border-0" width={'200px'} src={"/images/" + item.image} />
                                        </div>
                                        <div className="col-md-7 pb-4">
                                            <h5 className="card-category text-primary text-capitalize">{item.title}</h5>
                                            <p className="card-description ">{item.description.substring(0, 250)}... 
                                                <Link className="btn font-weight-bold" to={"/item/"+item.id}>
                                                    Voir plus
                                                </Link>
                                            </p>
                                            <p className="card-description">Quantité restante : {item.quantity}</p>
                                            <a className="btn btn-warning btn-round" href="#"><FcNext />Réserver</a>
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

export default CdList;