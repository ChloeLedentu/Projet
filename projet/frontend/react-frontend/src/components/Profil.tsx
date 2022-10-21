import React, { useState, ChangeEvent, useEffect } from "react";
import { getCurrentUser } from "../services/AuthService";
import UserService from "../services/UserService";
const Profil: React.FC = () => {

    const initUser = {
        id: null,
        firstname: '',
        lastname: '',
        email: '',
        nbBorrow: 0,
    };

    const [currentUser, setCurrentUser] = useState(initUser);
    const [message, setMessage] = useState<string>("");
    const [NbBorrow, setNbBorrow] = useState<number>(0);

    const getUser = () => {
        UserService.findByEmail(getCurrentUser().email)
            .then((response: any) => {
                setCurrentUser(response.data);
                setNbBorrow(Math.round(3 - response.data.nbBorrow));
            })
            .catch((e: Error) => {
                setMessage("ERROR 404");
            });
    };

    useEffect(() => {
        if (getCurrentUser().email) getUser();
    }, []);


    return (

        <div className="container">
            {currentUser ? (
                <div>
                    <div className="row">
                        <div className="col-md-6 ml-auto mr-auto">
                            <div className="profile">
                                <div className="name">
                                    <h3 className="title"> {currentUser.firstname} {currentUser.lastname}</h3>
                                    <h6> {currentUser.email} </h6>
                                    <p>
                                        Nombre de réservations restantes : {NbBorrow}
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            ) : (
                <div>
                    <p>404 not found</p>
                </div>
            )}
        </div>
    );
}

export default Profil;