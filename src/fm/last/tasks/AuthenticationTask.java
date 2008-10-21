package fm.last.tasks;

import fm.last.Utils;
import fm.last.radio.RadioHandshake;
import android.app.ProgressDialog;
import android.view.View.OnClickListener;
import android.widget.EditText;
import androidx.util.GUITask;
import androidx.util.ResultReceiver;

public class AuthenticationTask implements GUITask {
  private String username;
  private String md5Password;
  private ProgressDialog m_progress;
  private RadioHandshake m_loginTest;
  private ResultReceiver<RadioHandshake> resultReceiver;

  public AuthenticationTask(String username, String md5Password, 
      ProgressDialog m_progress, ResultReceiver<RadioHandshake> resultReceiver) {
    this.username = username;
    this.md5Password = md5Password;
    this.m_progress = m_progress;
    this.resultReceiver = resultReceiver;
  }
  
  public void executeNonGuiTask() throws Exception {
    m_loginTest = new RadioHandshake(username, md5Password);
    m_loginTest.connect();
  }

  public void handle_exception(Throwable t) {
    m_progress.dismiss();
  }

  public void after_execute() {
    m_progress.dismiss();
  }

 
}
