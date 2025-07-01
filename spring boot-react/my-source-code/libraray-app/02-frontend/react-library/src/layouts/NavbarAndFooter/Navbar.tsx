import { Link, NavLink } from "react-router-dom"
import { SpinnerLoading } from "../Utils/SpinnerLoading";
import { useOktaAuth } from "@okta/okta-react";

export const Navbar = () => {

    const { oktaAuth, authState } = useOktaAuth();

    if (!authState) {
        <SpinnerLoading />
    }

    const handleLogout = async () => oktaAuth.signOut();

    return (
        <nav className="navbar navbar-expand-lg navbar-dark main-color py-3">
            <div className="container-fluid">
                <span className="navbar-brand">Luv 2 Read</span>
                <button className="navbar-toggler" type='button'
                    data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                    aria-controls='navbarNavDropdown' aria-expanded='false'
                    aria-label='Toggle Navigation'
                >
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id='navbarNavDropdown'>
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            <NavLink to="/home" className="nav-link">Home</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink to="search" className="nav-link">Search Books</NavLink>
                        </li>
                        {authState?.isAuthenticated && 
                            <li className="nav-item">
                                <NavLink to="/shelf" className="nav-link">Shelf</NavLink>
                            </li>
                        }
                        {authState?.isAuthenticated && 
                            <li className="nav-item">
                                <NavLink to="/fees" className="nav-link">Pay fees</NavLink>
                            </li>
                        }
                        {authState?.isAuthenticated && authState.accessToken?.claims?.userType === 'admin' &&
                            <li className="nav-item">
                                <NavLink className="nav-link" to="/admin">Admin</NavLink>
                            </li>
                        }
                    </ul>
                    <ul className="navbar-nav ms-auto">
                        {!authState?.isAuthenticated ?
                            <li className="nav-item m-1">
                                <Link type='button' to="/login" className="btn btn-outline-light">Sign in</Link>
                            </li>
                            :
                            <li>
                                <button className="btn btn-outline-light" onClick={handleLogout}>Logout</button>
                            </li>
                        }

                    </ul>
                </div>
            </div>
        </nav>
    )
}