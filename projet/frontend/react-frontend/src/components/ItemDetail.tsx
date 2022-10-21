import React, { useState, useEffect } from "react";
import { useParams } from 'react-router-dom';
import ItemService from "../services/ItemService";
import { FcNext } from 'react-icons/fc';
import Moment from 'moment';

const ItemDetail: React.FC = () => {

    const { id } = useParams();
    const initItem = {
        id: null,
        title: '',
        author: '',
        description: '',
        dateRelease: new Date,
        image: '',
        quantity: 0,
        createdOn: new Date,
        numISBN: 0,
        duration: 0,
        type: '',
        nbTitle: 0
    }

    const [Type, setType] = useState<string>("");

    const [currentItem, setCurrentItem] = useState(initItem);
    const [message, setMessage] = useState<string>("");

    const getItem = (id: string) => {
        ItemService.findById(id)
            .then((response: any) => {
                if (response.data.numISBN != null) setType("Book");
                else if (response.data.type != null) setType("Dvd");
                else if (response.data.nbTitle != null) setType("Cd");
                setCurrentItem(response.data);
            })
            .catch((e: Error) => {
                setMessage("ERROR 404");
            });
    };

    useEffect(() => {
        if (id) getItem(id);
    }, [id]);

    return (
        <div className="section">
            {currentItem.title ? (
                <div className="container">
                    <div className="main main-raised main-product">
                        <div className="row">
                            <div className="col-md-6 col-sm-6">
                                <div className="tab-content">
                                    <img width={"400px"} src={"/images/" + currentItem.image} alt={currentItem.image} />
                                </div>
                            </div>
                            <div className="col-md-6 col-sm-6">
                                <h2 className="title">{currentItem.title}</h2>
                                <h4 className="text-danger">{currentItem.author}</h4>
                                <div className="card-body pt-4">
                                    <p>{currentItem.description}</p>
                                    <p>Sortie le {Moment(currentItem.dateRelease).format("DD-MM-YYYY")}</p>
                                    {
                                        Type === "Book" ? <div><p><u>Autre Information :</u></p><p>Numéro ISBN : {currentItem.numISBN}</p></div>
                                            : Type === "Dvd" ? <div><p><u>Autre Information :</u></p><p className="text-info">{currentItem.type}</p><p>Durée: {currentItem.duration} min</p></div>
                                                : Type === "Cd" ? <div><p><u>Autre Information :</u></p><p>Nombre de titres : {currentItem.nbTitle}</p></div>
                                                    : <div></div>
                                    }
                                    <hr />
                                    <p className="card-description">Quantité restante : {currentItem.quantity}</p>
                                    <a className="btn btn-warning btn-round" href="#"><FcNext />Réserver</a>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            ) : (
                <div>
                    <h2>{message}</h2>
                </div>
            )}
        </div>
    );
}

export default ItemDetail;