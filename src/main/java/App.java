import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 游戏主程序的启动入口类, 实现 ApplicationListener 接口
 */
public class App implements ApplicationListener {

    // 纹理画布
    private SpriteBatch batch;
    // 纹理
    private Texture texture;

    @Override
    public void create() {
        // 创建纹理画布
        batch = new SpriteBatch();

        /*
         * 使用 assets 文件夹中的图片 badlogic.jpg 创建纹理,
         * 文件路径相对于 assets 文件夹根目录, 如果图片放在子目录, 则路径为 "xxx/badlogic.jpg"
         */
        texture = new Texture("badlogic.jpg");
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void render() {
        // 设置清屏颜色为红色（RGBA）
        Gdx.gl.glClearColor(1, 0, 0, 1);
        // 清屏
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /* 使用画笔将纹理绘制在屏幕上 */

        batch.begin();				// 绘制开始
        batch.draw(texture, 0, 0);	// 在屏幕左下角绘制纹理
        batch.end();				// 绘制结束
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }

}