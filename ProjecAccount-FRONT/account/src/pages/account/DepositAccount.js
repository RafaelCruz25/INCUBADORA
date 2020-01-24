import React, { Component } from 'react';

import axios from '../../utils/httpClient';
import Field from '../../component/Field';
import { Link } from 'react-router-dom';

class DepositAccount extends Component{
    state = {
      accounts: {
        amount: ""
      },

      errors: {},
      globalError: ""
    };


    retrieveAccountsId = () =>
      this.props.match.params.id;

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
      event.preventDefault();

      axios.post(`/accounts/deposit/${this.retrieveAccountsId()}`, this.state.accounts)
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
           <h1 className="page-title text-center">Deposit</h1>

           {globalError ? <div className="alert alert-danger">
             {globalError}
             </div> : <></>}

          <form onSubmit={this.handleSubmit}>
              <Field name="amount"
                    label="Amount"
                    value={accounts.amount}
                    errors={errors["amount"]}
                    onChange={this.handleChange}
                    type='number'
                    />

              <div className="float-right btn-group">
                <Link to="/accounts" className="btn btn-primary">Return</Link>&nbsp;
                <button type="submit" className="btn btn-success">Confirm</button>
              </div>
          </form>
        </div>
      );
    }
}

export default DepositAccount;
