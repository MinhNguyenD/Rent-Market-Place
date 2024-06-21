import React from "react";
import ReactDOM from "react-dom/client";
import Home from "./pages/Home.jsx";
import "./index.css";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Profile from "./pages/Profile.jsx";
import Login from "./pages/Login.jsx";
import CreatePost from "./pages/CreatePost.jsx";
import { PostsProvider } from "./context/PostContext.jsx";
const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
  },
  {
    path: "/profile",
    element: <Profile />,
  },
  {
    path: "/add-post",
    element: <CreatePost />,
  },
  {
    path: "/login",
    element: <Login />,
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <PostsProvider>
      {/* if router is too big you can separate it to a new module and import it */}
      <RouterProvider router={router} />
    </PostsProvider>
    
  </React.StrictMode>
);
