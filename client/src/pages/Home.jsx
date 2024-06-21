import Header from "../components/Header";
import PostPreview from "../components/PostPreview";
import { usePost } from "../context/PostContext";
function Home() {
  const { posts, handleDelete } = usePost();
  return (
    <>
      <Header />
      <div className="container">
        <form className="d-flex">
          <input
            className="form-control me-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
          />
          <button className="btn btn-outline-success" type="submit">
            Search
          </button>
        </form>
      </div>
      <br></br>
      <div className="container">

            {posts.length > 0 ? (
                posts.map((post) => (
                  <PostPreview post={post} key={post.id} handleDelete={handleDelete} />
                ))
            ) : (
              <div className="no-tasks">No Tasks</div>
            )}
            </div>

    </>
  );
}

export default Home;
