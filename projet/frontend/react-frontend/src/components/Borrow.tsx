import React, { useState, useEffect, ChangeEvent, ErrorInfo } from "react";
import { useParams, useNavigate, Link, NavigateFunction } from 'react-router-dom';
import { Formik, Field, Form, ErrorMessage } from "formik";
import * as Yup from "yup";
import * as AuthService from "../services/AuthService";
import { getCurrentUser } from "../services/AuthService";
import UserService from "../services/UserService";
import BorrowData from "../types/Borrow";
import UserData from "../types/User";
import Moment from 'moment';
import BorrowService from "../services/BorrowService";
import { ErrorCallback } from "typescript";

type Props = {}

const BorrowList: React.FC<Props> = () => {
    let navigate: NavigateFunction = useNavigate();

    const [borrows, setBorrows] = useState<Array<BorrowData>>([]);
    const [currentUser, setCurrentUser] = useState<UserData | undefined>(undefined);
    const initialValues: { id: number; quantity: number; } = { id: 0, quantity: 0 };
    const [message, setMessage] = useState<string>("");
    

    const validationSchema = Yup.object().shape({
        quantity: Yup.number()
            .max(3, '3 réservations maximum')
            .min(1, 'Impossible de ne pas avoir de quantité à rendre')
            .required('La quantité est requise')
    });

    const retrieveBorrows = () => {
        UserService.findBorrow(getCurrentUser().id)
            .then((response: any) => {
                setBorrows(response.data);
            })
            .catch((e: Error) => {
                console.log(e.message);
            });
    };


    const BorrowReturn = (formValue: { id: number; quantity: number }) => {
        const {id, quantity } = formValue;
        setMessage("");

        BorrowService.returnBorrow(2, quantity).then(
            () => {
                window.location.reload();
            },
            (error) => {
                setMessage(error.response.data);
            }
        );
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
                                                            (
                                                                <Formik
                                                                    validationSchema={validationSchema}
                                                                   initialValues={initialValues}
                                                                    onSubmit={BorrowReturn}
                                                                >
                                                                    <Form>
                                                                        <div className="form-group">
                                                                            <label htmlFor="quantity">Quantité</label>
                                                                            <Field name="quantity" type="number" className="form-control" />
                                                                            <ErrorMessage
                                                                                name="quantity"
                                                                                component="div"
                                                                                className="alert alert-danger"
                                                                            />
                                                                        </div>
                                                                        <button type="submit" className="btn btn-primary btn-block">
                                                                            Rendre
                                                                        </button>
                                                                        {message && (
                                                                            <div className="form-group">
                                                                                <div className="alert alert-danger" role="alert">
                                                                                    {message}
                                                                                </div>
                                                                            </div>
                                                                        )}
                                                                    </Form>
                                                                </Formik>
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