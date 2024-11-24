import React, { Component } from "react";
import "../assets/css/index.css";

class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoginModalOpen: false,
      isSignupModalOpen: false,
    };
  }

  openLoginModal = () => {
    this.setState({ isLoginModalOpen: true });
  };

  closeLoginModal = () => {
    this.setState({ isLoginModalOpen: false });
  };

  openSignupModal = () => {
    this.setState({ isSignupModalOpen: true });
  };

  closeSignupModal = () => {
    this.setState({ isSignupModalOpen: false });
  };

  render() {
    const { isLoginModalOpen, isSignupModalOpen } = this.state;

    return (
      <div>
        <header>
          <nav>
            <a href="#home">Home</a>
            <a href="#news">News</a>
          </nav>
          <div className="auth">
            <button onClick={this.openLoginModal}>Login</button>
            <button onClick={this.openSignupModal}>Sign up</button>
          </div>
        </header>
        <section id="home" className="section home">
          <div className="logo">
            <img src="../assets/img/logo.png" alt="Opportu Logo" />
          </div>
          <div className="tagline">Develop your dream by your hands</div>
        </section>
        <section id="news" className="section news">
          <h2>Latest News</h2>
          <ul>
            <li>1</li>
            <li>2</li>
            <li>3</li>
            <li>4</li>
          </ul>
        </section>

        {/* Signup Modal */}
        {isSignupModalOpen && (
          <div className="modal">
            <div className="modal-content">
              <button className="close-btn" onClick={this.closeSignupModal}>
                &times;
              </button>
              <h2>As</h2>
              <div className="button-container">
                <button className="role-btn">
                  <img src="img/Group 20.png" alt="Student Role" style={{ width: "150px" }} />
                </button>
                <button className="role-btn">
                  <img src="img/Group 19.png" alt="Company Role" style={{ width: "150px" }} />
                </button>
              </div>
            </div>
          </div>
        )}

        {/* Login Modal */}
        {isLoginModalOpen && (
          <div className="modal">
            <div className="modal-content">
              <button className="close-btn" onClick={this.closeLoginModal}>
                &times;
              </button>
              <h2>Login</h2>
              <form>
                <div className="form-group">
                  <label htmlFor="email">Email:</label>
                  <input type="email" id="email" name="email" placeholder="Enter your email" required />
                </div>
                <div className="form-group">
                  <label htmlFor="password">Password:</label>
                  <input type="password" id="password" name="password" placeholder="Enter your password" required />
                </div>
                <button type="submit" className="submit-btn">
                  Login
                </button>
              </form>
            </div>
          </div>
        )}
      </div>
    );
  }
}

export default Home;
