import React, { createContext, useContext, useState, useEffect } from "react";
import Posts from "../pages/Post";

//create context
const PostsContext = createContext();

// instead of using useContext(TaskContext) -> map it to your own usePost context function
export const usePost = () => useContext(PostsContext);

export const PostsProvider = ({ children }) => {
  const [posts, setPosts] = useState([]);
  useEffect(() => {
    const fetchPosts = async () => {
      try {
        // if not specify -> it is a get request
        const response = await fetch(`http://localhost:5000/rooms/`);
        if (!response.ok) {
          throw new Error("Network response was not ok.");
        }
        const data = await response.json();
        setPosts(data);
      } catch (error) {
        console.error("Failed to fetch posts:", error);
      }
    };

    fetchPosts();
  }, []);

  const handleAdd = async ({ title, description, numBed }) => {
    try {
      const response = await fetch("http://localhost:3000/rooms", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          title,
          description,
          numBed,
        }),
      });
      if (!response.ok) {
        throw new Error("Network response was not ok.");
      }
      const data = await response.json();

      setPosts((prevPosts) => [...prevPosts, data]);
    } catch (error) {
      console.error("Failed to add post:", error);
    }
  };

  const handleDelete = async (id) => {
    try {
      const response = await fetch(`http://localhost:3000/rooms/${id}`, {
        method: "DELETE",
      });
      if (!response.ok) {
        throw new Error("Network response was not ok.");
      }
      setPosts((currentPosts) => currentPosts.filter((post) => post.id !== id));
    } catch (error) {
      console.error("Failed to delete task:", error);
    }
  };


  return (
    <PostsContext.Provider value={{ posts, handleAdd, handleDelete }}>
      {children}
    </PostsContext.Provider>
  );
};