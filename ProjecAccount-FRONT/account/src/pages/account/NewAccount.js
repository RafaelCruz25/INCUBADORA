import React, { Component} from 'react';
import axios from '../../utils/httpClient';


import Field from '../../component/Field'
import Select from '../../component/SelectAccount';
import { Link } from 'react-router-dom';


class NewAccount extends Component{

    state = {
        accounts: {
            holder: "",
            balance: "",
            loanLimit: "",
            typeAccount: ""

        },
        errors: {},
        globalError: ""
    };



    handleChange = (event) => {
        let field = event.target.name;
        let value = event.target.value;

        this.setState(({ accounts }) => ({
            accounts: {
                ...accounts,
                [field]: value
            }
        }))
    };

    handleSubmit = (event) => {
        axios.post("/accounts", this.state.accounts)
            .then(() => this.props.history.push("/"))
            .catch(({ response }) => {
                if(response.status === 400){
                    this.setState({
                        errors: response.data
                    })
                }

                this.setState({
                    globalError: response.data.message
                })
            });
            event.preventDefault();
    };

    render(){
        const { accounts, errors, globalError } = this.state;
        return(
            <div>
                <h1 className="page-title text-center">New Account</h1>

                {globalError ? <div className="alert alert-danger"> {globalError} </div> : <></>}

                <form onSubmit={this.handleSubmit}>
                    <Field name="holder"
                           label="Holder"
                           value={accounts.holder}
                           errors={errors["holder"]}
                           onChange={this.handleChange}/>

                    <Field name="balance"
                           label="Balance"
                           value={accounts.balance}
                           errors={errors["balance"]}
                           onChange={this.handleChange}
                           type='number'/>

                    <Field name="loanLimit"
                           label="Loan Limit"
                           value={accounts.loanLimit}
                           errors={errors["loanLimit"]}
                           onChange={this.handleChange}
                           type='number'/>
                    <Select
                        value={accounts.typeAccount}
                        onChange={this.handleChange}
                    />


                    <div className="float-right btn-group">
                        <Link to="/accounts" className="btn btn-primary">Return</Link>&nbsp;
                        <button type="submit" className="btn btn-success">Save</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default NewAccount;
