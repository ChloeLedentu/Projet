import React, { useState, useEffect, ChangeEvent } from "react";
import { useParams, useNavigate, Link } from 'react-router-dom';
import * as AuthService from "../services/AuthService";
import { getCurrentUser } from "../services/AuthService";
import UserService from "../services/UserService";
import BorrowData from "../types/Borrow";
import UserData from "../types/User";
import Moment from 'moment';
import BorrowService from "../services/BorrowService";

const BorrowList: React.FC = () => {

    const [borrows, setBorrows] = useState<Array<BorrowData>>([]);
    const [currentUser, setCurrentUser] = useState<UserData | undefined>(undefined);

    const retrieveBorrows = () => {
        UserService.findBorrow(getCurrentUser().id)
            .then((response: any) => {
                setBorrows(response.data);
                
            })
            .catch((e: Error) => {
                console.log(e.message);
            });
    };
 

    useEffect(() => {
        const user = AuthService.getCurrentUser();
        if (user) {
            setCurrentUser(user);
            retrieveBorrows();
        }

    }, []);

    return (
        <div className="main main-raised">
            {currentUser && (
                <div className="section">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-10 ml-auto mr-auto">
                                <div className="title pb-4">
                                    <h3>Liste des objets réservés</h3>
                                </div>
                                <div className="card card-plain">
                                    {borrows && borrows.map((borrow, index) => (
                                        <div className="row m-2" key={index}>
                                            <div className="col-md-5">
                                                <img className="image img-thumbnail border-0" width={'200px'} src={"/images/" + borrow.items[0].image} alt="img_item" />
                                            </div>
                                            <div className="col-md-7 pb-4">
                                                <h5 className="card-category text-primary text-capitalize">{borrow.items[0].title}</h5>
                                                <h6 className="card-description text-capitalize"> {borrow.items[0].author}</h6>
                                                <div className="card-description">
                                                    <>
                                                        <p>Quantité réservé : {borrow.quantity}</p>
                                                        <p><>Date d'emprunt : {Moment(borrow.dateTake).format("DD MM YYYY")}</></p>
                                                        {borrow.dateReturn ?
                                                            (<p><>Date de retour : {Moment(borrow.dateReturn).format("DD MM YYYY")}</></p>)
                                                            :
                                                            (<button type="submit" className="btn btn-primary btn-block" >
                                                                Rendre
                                                            </button>
                                                            )
                                                        }

                                                    </>
                                                </div>
                                            </div>
                                            <hr />
                                        </div>

                                    ))}
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            )}
        </div>

    );
}

export default BorrowList;