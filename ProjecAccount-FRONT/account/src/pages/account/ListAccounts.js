import React, { Component } from 'react';

import axios from '../../utils/httpClient';

import { Link } from 'react-router-dom';

class ListAccounts extends Component{
    state = {
        accounts: []
    };

    componentDidMount(){
        this.retrieveAccounts();
    }

    handleRemove = (id) => {
        axios.delete(`/accounts/${id}`)
            .then(() => this.retrieveAccounts())
    };

    retrieveAccounts() {
        axios.get("/accounts")
            .then(({ data }) =>
            this.setState({
                accounts: data
            })
            )
    }

    render(){
      return <div>
        <h1 className="page-title text-center">List Accounts</h1>
        <table className="table text-center table-hover">
          <thead className="thead-dark">
            <tr>
              <th>ID</th>
              <th>Holder</th>
              <th>Balance</th>
              <th>Loan Limit</th>
              <th>Account Type</th>
              <th>Creation Date</th>
              <th>Updated Date</th>
              <th>Actions</th>
            </tr>
            </thead>
              <tbody>
                {this.state.accounts.map(accounts => <tr key={accounts.id}>
                  <td>{accounts.id}</td>
                  <td>{accounts.holder}</td>
                  <td>{accounts.balance}</td>
                  <td>{accounts.loanLimit}</td>
                  {
                    accounts.typeAccount === 'CHECKINGACCOUNT' ?  <td>Conta Corrente</td> :  <td>Conta Poupança</td>
                  }
                  <td>{accounts.createdAt}</td>
                  <td>{accounts.updatedAt}</td>
                  <td>
                    <button className="btn btn-sm btn-danger" onClick={() => this.handleRemove(accounts.id)}>
                      Remove
                    </button>&nbsp;
                    <Link to={`/accounts/edit/${accounts.id}`} className="btn btn-sm btn-primary">Update</Link>&nbsp;
                    <Link to={`/accounts/withdraw/${accounts.id}`} className="btn btn-sm btn-primary">Withdraw</Link>&nbsp;
                    <Link to={`/accounts/deposit/${accounts.id}`} className="btn btn-sm btn-primary">Deposit</Link>&nbsp;
                  </td>
                </tr>)}
              </tbody>
        </table>
        <div className="float-right">
          <Link to="/accounts/new" className="btn btn-primary">New Account</Link>&nbsp;

        </div>
      </div>
    }
}

export default ListAccounts;
