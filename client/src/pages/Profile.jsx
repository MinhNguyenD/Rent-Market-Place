import Header from "../components/Header";
import "../styles/Profile.css";
const Profile = () => {
  return (
    <>
      <Header />
      <div className="container">
        {/* <img src="profile_picture.jpg" alt="Profile Picture"/> */}
        <h1>John Doe</h1>
        <p>Email: johndoe@example.com</p>
        <p>Location: New York, USA</p>
        <div class="bio">
          <h2>Bio</h2>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget
            consectetur turpis. Integer ultricies eros nec erat interdum, id
            eleifend velit consectetur.
          </p>
        </div>
      </div>
    </>
  );
};

export default Profile;
